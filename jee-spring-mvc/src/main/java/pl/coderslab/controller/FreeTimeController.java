package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class FreeTimeController {

    @GetMapping("/free-time")
    @ResponseBody
    public String freeTime() {
        List<DayOfWeek> workingDays = List.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
                DayOfWeek.THURSDAY, DayOfWeek.FRIDAY);

        LocalDateTime testDate = LocalDateTime.of(2022, 7, 29, 16, 42);
        LocalDateTime now = LocalDateTime.now();
        if (testDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) || testDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            return "Wolne";
        }
        if (workingDays.contains(testDate.getDayOfWeek())) {
            if (testDate.getHour() >= 9 &&
                    (testDate.getHour() < 17 || testDate.getHour() == 17 && testDate.getMinute() == 0)) {
                return "Pracuję, nie dzwoń";
            }
            return "Po pracy";
        }
        return "Błąd";
    }
}
