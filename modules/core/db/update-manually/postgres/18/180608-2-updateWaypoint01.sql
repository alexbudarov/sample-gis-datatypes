alter table CRUISESAMPLE_WAYPOINT add constraint FK_CRUISESAMPLE_WAYPOINT_ON_ROUTE foreign key (ROUTE_ID) references CRUISESAMPLE_ROUTE(ID);
create index IDX_CRUISESAMPLE_WAYPOINT_ON_ROUTE on CRUISESAMPLE_WAYPOINT (ROUTE_ID);