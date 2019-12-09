package com.xyinc.xyinc.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class InterestPoint {
    @Id
    public String name;
    public Integer point_x;
    public Integer point_y;

    public InterestPoint(String name, Integer point_x, Integer point_y) {
        this.name = name;
        this.point_x = point_x;
        this.point_y = point_y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoint_x() {
        return point_x;
    }

    public void setPoint_x(Integer point_x) {
        this.point_x = point_x;
    }

    public Integer getPoint_y() {
        return point_y;
    }

    public void setPoint_y(Integer point_y) {
        this.point_y = point_y;
    }

    public double  calculateDistance(int x, int y)
    {
        return  Math.sqrt(Math.pow(this.point_x - x, 2) + Math.pow(this.point_y - y, 2));
    }
}
