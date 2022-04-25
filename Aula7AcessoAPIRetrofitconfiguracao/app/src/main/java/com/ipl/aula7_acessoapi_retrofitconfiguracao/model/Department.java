
package com.ipl.aula7_acessoapi_retrofitconfiguracao.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Department {

    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("professors")
    private List<Professor> mProfessors;

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

    public List<Professor> getProfessors() {
        return mProfessors;
    }

    public void setProfessors(List<Professor> professors) {
        mProfessors = professors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mProfessors=" + mProfessors +
                '}';
    }
}
