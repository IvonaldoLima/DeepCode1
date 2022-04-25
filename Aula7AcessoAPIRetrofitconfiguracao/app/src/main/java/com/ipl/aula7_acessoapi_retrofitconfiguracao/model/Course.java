
package com.ipl.aula7_acessoapi_retrofitconfiguracao.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Course {

    @SerializedName("allocations")
    private List<Allocation> mAllocations;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;

    public List<Allocation> getAllocations() {
        return mAllocations;
    }

    public void setAllocations(List<Allocation> allocations) {
        mAllocations = allocations;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "mAllocations=" + mAllocations +
                ", mId=" + mId +
                ", mName='" + mName + '\'' +
                '}';
    }
}
