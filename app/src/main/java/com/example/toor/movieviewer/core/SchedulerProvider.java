package com.example.toor.movieviewer.core;

import io.reactivex.Scheduler;

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler io();

}
