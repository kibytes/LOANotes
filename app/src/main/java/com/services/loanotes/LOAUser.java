package com.services.loanotes;

import android.os.Parcel;
import android.os.Parcelable;

public class LOAUser implements Parcelable {
    private String fullName;
    private String email;
    private String phone;
    private String password;

    protected LOAUser(Parcel in) {
        fullName = in.readString();
        email = in.readString();
        phone = in.readString();
        password = in.readString();
    }

    public static final Creator<LOAUser> CREATOR = new Creator<LOAUser>() {
        @Override
        public LOAUser createFromParcel(Parcel in) {
            return new LOAUser(in);
        }

        @Override
        public LOAUser[] newArray(int size) {
            return new LOAUser[size];
        }
    };

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LOAUser(String userName, String userPassword) {
        password = userPassword;
    }

    public LOAUser(String uname, String uemail, String uphone, String upass) {
        setFullName(uname);
        setEmail(uemail);
        setPhone(uphone);
        setPassword(upass);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(fullName);
        parcel.writeString(email);
        parcel.writeString(phone);
        parcel.writeString(password);
    }
}
