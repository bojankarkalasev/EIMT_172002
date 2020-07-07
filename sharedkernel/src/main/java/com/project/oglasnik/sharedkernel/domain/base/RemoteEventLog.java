package com.project.oglasnik.sharedkernel.domain.base;

import com.project.oglasnik.sharedkernel.infra.eventlog.StoredDomainEvent;

import java.util.List;

public interface RemoteEventLog {

    List<StoredDomainEvent> events();
}
