package com.epam.intro.subtask3;

import lombok.Builder;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Calendar {
    public enum Month {
        JANUARY(31, 1),
        FEBRUARY(28, 2),
        MARCH(31, 3),
        APRIL(30, 4),
        MAY(31, 5),
        JUNE(30, 6),
        JULY(31, 7),
        AUGUST(31, 8),
        SEPTEMBER(30, 9),
        OCTOBER(31, 10),
        NOVEMBER(30, 11),
        DECEMBER(31, 12);
        private Integer amountOfDays;

        private Integer id;

        Month(Integer amountOfDays, Integer id) {
            this.amountOfDays = amountOfDays;
            this.id = id;
        }

        public Month next() {
            return Arrays.stream(values()).filter(it -> it.id == id + 1).findAny().orElse(JANUARY);
        }

        public Integer getAmountOfDays() {
            return amountOfDays;
        }

    }

    public enum DayOfWeek {
        MONDAY(false, 1),
        TUESDAY(false, 2),
        WEDNESDAY(false, 3),
        THURSDAY(false, 4),
        FRIDAY(false, 5),
        SATURDAY(true, 6),
        SUNDAY(true, 7);

        private boolean isWeekEnd;

        private int id;

        DayOfWeek(boolean isWeekEnd, int id) {
            this.isWeekEnd = isWeekEnd;
            this.id = id;
        }

        public DayOfWeek next() {
            return Arrays.stream(values()).filter(it -> it.id == id + 1).findAny().orElse(MONDAY);
        }

        public boolean isWeekEnd() {
            return isWeekEnd;
        }
    }

    @Builder
    @Data
    public static class Day {
        private Integer dayOfYear;
        private Integer dayOfMonth;
        private Month month;
        private DayOfWeek dayOfWeek;
        private boolean isHoliday;
    }

    private Map<Month, List<Day>> calendar = new HashMap<>();

    private Calendar() {
    }

    public static Calendar getInstance(DayOfWeek firstDayOfYear) {
        Calendar calendar = new Calendar();
        DayOfWeek currentDayOfWeek = firstDayOfYear;
        int numberOfDays = Arrays.stream(Month.values()).map(Month::getAmountOfDays).mapToInt(Integer::valueOf).sum();
        int dayOfMonth = 1;
        Month currentMonth = Month.JANUARY;
        for (int i = 1; i <= numberOfDays; i++) {
            Day day = Day.builder().dayOfYear(i).dayOfMonth(dayOfMonth).month(currentMonth).dayOfWeek(currentDayOfWeek).build();
            calendar.calendar.putIfAbsent(currentMonth, new ArrayList<>());
            calendar.calendar.get(currentMonth).add(day);
            if (dayOfMonth == currentMonth.getAmountOfDays()) {
                currentMonth = currentMonth.next();
                dayOfMonth = 1;
            } else {
                dayOfMonth++;
            }
            currentDayOfWeek = currentDayOfWeek.next();
        }
        return calendar;
    }
    public void addHoliday(Month month, Integer dayOfMonth) {
        calendar.get(month).get(dayOfMonth).setHoliday(true);
    }
    public List<Day> getWeekendsAndHolidays() {
        return calendar.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(it -> it.isHoliday() || it.getDayOfWeek().isWeekEnd())
                .collect(Collectors.toList());
    }
}
