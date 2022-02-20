package com.sohaib.taskManagementBackend.resources;

import java.util.List;

public class CalendarListResource {
  
  private List<CalendarResource> events;

  public List<CalendarResource> getEvents() {
    return events;
  }

  public void setEvents(List<CalendarResource> events) {
    this.events = events;
  }
}
