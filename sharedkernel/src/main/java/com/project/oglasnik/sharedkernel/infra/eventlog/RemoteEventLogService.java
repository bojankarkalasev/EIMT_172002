package com.project.oglasnik.sharedkernel.infra.eventlog;


import com.project.oglasnik.sharedkernel.domain.base.RemoteEventLog;

public interface RemoteEventLogService {

    String source();

    RemoteEventLog currentLog(long lastProcessedId);

}
