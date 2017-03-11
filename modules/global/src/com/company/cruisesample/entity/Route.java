package com.company.cruisesample.entity;

import javax.persistence.*;

import com.company.cruisesample.gis.converters.CubaLineStringWKTConverter;
import com.company.cruisesample.gis.datatypes.LineStringDatatype;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.vividsolutions.jts.geom.LineString;

import java.util.Optional;
import java.util.Set;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.List;

@Table(name = "CRUISESAMPLE_ROUTE")
@Entity(name = "cruisesample$Route")
public class Route extends StandardEntity {
    private static final long serialVersionUID = -740433824286775135L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @JoinTable(name = "CRUISESAMPLE_ROUTE_PORT_LINK",
        joinColumns = @JoinColumn(name = "ROUTE_ID"),
        inverseJoinColumns = @JoinColumn(name = "PORT_ID"))
    @ManyToMany
    protected List<Port> ports;

    @OrderBy("eta")
    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "route")
    protected List<Waypoint> waypoints;

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }


    public List<Port> getPorts() {
        return ports;
    }

    public void setPorts(List<Port> ports) {
        this.ports = ports;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



}