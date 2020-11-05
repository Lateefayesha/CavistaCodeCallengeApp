package com.appynitty.cavistacodecallengeapp.common.rxjava;


import io.reactivex.Scheduler;

/**
 * Created by Ayan Dey on 30/10/20.
 */

/**
 *   6) The trampoline Scheduler is very similar to immediate because it also schedules tasks in
 *       the same thread, effectively blocking.
 *
 *
 *   2) io Scheduler is similar to the newThread except for the fact that already started threads
 *   are recycled and can possibly handle future requests.
 *
 *   3) Computation Scheduler by default limits the number of threads running in parallel to
 *   the value of availableProcessors(), as found in the Runtime.getRuntime() utility class.
 *
 *   5) Test Scheduler is used only for testing purposes, and we'll never see it in production code.
 *   Its main advantage is the ability to advance the clock, simulating time passing by arbitrarily:
 *
 *   7) Schedulers.immediate is a special scheduler that invokes a task within the client thread in
 *   a blocking way, rather than asynchronously and returns when the action is completed:
 *
 *   8) newThread scheduler simply starts a new thread every time it is requested via subscribeOn() or observeOn().
 */
interface Schedulers  {
    Scheduler mainThread();
    Scheduler io();
    Scheduler computation();
    Scheduler trampoline();
    Scheduler newThread();


}

