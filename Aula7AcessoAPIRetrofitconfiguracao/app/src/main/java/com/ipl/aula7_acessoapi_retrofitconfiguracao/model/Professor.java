
package com.ipl.aula7_acessoapi_retrofitconfiguracao.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Professor {

    @SerializedName("allocations")
    private List<Allocation> mAllocations;
    @SerializedName("cpf")
    private String mCpf;
    @SerializedName("department")
    private Department mDepartment;
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

    public String getCpf() {
        return mCpf;
    }

    public void setCpf(String cpf) {
        mCpf = cpf;
    }

    public Department getDepartment() {
        return mDepartment;
    }

    public void setDepartment(Department department) {
        mDepartment = department;
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
        return "Professor{" +
                "mAllocations=" + mAllocations +
                ", mCpf='" + mCpf + '\'' +
                ", mDepartment=" + mDepartment +
                ", mId=" + mId +
                ", mName='" + mName + '\'' +
                '}';
    }
}
