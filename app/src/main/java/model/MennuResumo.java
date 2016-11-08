package model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 30/10/2016.
 */
public class MennuResumo implements Parcelable {
    private long id;
    private String cpo01;
    private String cpo02;
    private String cpo03;
    private String cpo04;
    private String cpo05;
    private String cpo06;
    private String cpo07;
    private String cpo08;
    private String cpo09;
    private String cpo10;
    private String cpo11;
    private String cpo12;
    private String cpo13;
    private String cpo14;
    private String cpo15;
    private String cpo16;
    private String cpo17;
    private String cpo18;
    private String cpo19;
    private String cpo20;
    private String cpo21;
    private String cpo22;
    private String cpo23;
    private String cpo24;
    private String cpo25;
    private String cpo26;
    private String cpo27;
    private String cpo28;

    public MennuResumo(String cpo01, String cpo02, String cpo03, String cpo04, String cpo05) {
        this.cpo01 = cpo01;
        this.cpo02 = cpo02;
        this.cpo03 = cpo03;
        this.cpo04 = cpo04;
        this.cpo05 = cpo05;
    }

    public MennuResumo(long id, String cpo01, String cpo02, String cpo03, String cpo04, String cpo05) {
        this.id = id;
        this.cpo01 = cpo01;
        this.cpo02 = cpo02;
        this.cpo03 = cpo03;
        this.cpo04 = cpo04;
        this.cpo05 = cpo05;
    }

    public MennuResumo(String cpo01, String cpo02, String cpo03, String cpo04, String cpo05, String cpo06, String cpo07, String cpo08, String cpo09, String cpo10, String cpo11, String cpo12, String cpo13, String cpo14, String cpo15, String cpo16, String cpo17, String cpo18, String cpo19, String cpo20, String cpo21, String cpo22, String cpo23, String cpo24, String cpo25, String cpo26, String cpo27, String cpo28) {
        this.cpo01 = cpo01;
        this.cpo02 = cpo02;
        this.cpo03 = cpo03;
        this.cpo04 = cpo04;
        this.cpo05 = cpo05;
        this.cpo06 = cpo06;
        this.cpo07 = cpo07;
        this.cpo08 = cpo08;
        this.cpo09 = cpo09;
        this.cpo10 = cpo10;
        this.cpo11 = cpo11;
        this.cpo12 = cpo12;
        this.cpo13 = cpo13;
        this.cpo14 = cpo14;
        this.cpo15 = cpo15;
        this.cpo16 = cpo16;
        this.cpo17 = cpo17;
        this.cpo18 = cpo18;
        this.cpo19 = cpo19;
        this.cpo20 = cpo20;
        this.cpo21 = cpo21;
        this.cpo22 = cpo22;
        this.cpo23 = cpo23;
        this.cpo24 = cpo24;
        this.cpo25 = cpo25;
        this.cpo26 = cpo26;
        this.cpo27 = cpo27;
        this.cpo28 = cpo28;
    }

    public MennuResumo(long id, String cpo01, String cpo02, String cpo03, String cpo04, String cpo05, String cpo06, String cpo07, String cpo08, String cpo09, String cpo10, String cpo11, String cpo12, String cpo13, String cpo14, String cpo15, String cpo16, String cpo17, String cpo18, String cpo19, String cpo20, String cpo21, String cpo22, String cpo23, String cpo24, String cpo25, String cpo26, String cpo27, String cpo28) {
        this.id = id;
        this.cpo01 = cpo01;
        this.cpo02 = cpo02;
        this.cpo03 = cpo03;
        this.cpo04 = cpo04;
        this.cpo05 = cpo05;
        this.cpo06 = cpo06;
        this.cpo07 = cpo07;
        this.cpo08 = cpo08;
        this.cpo09 = cpo09;
        this.cpo10 = cpo10;
        this.cpo11 = cpo11;
        this.cpo12 = cpo12;
        this.cpo13 = cpo13;
        this.cpo14 = cpo14;
        this.cpo15 = cpo15;
        this.cpo16 = cpo16;
        this.cpo17 = cpo17;
        this.cpo18 = cpo18;
        this.cpo19 = cpo19;
        this.cpo20 = cpo20;
        this.cpo21 = cpo21;
        this.cpo22 = cpo22;
        this.cpo23 = cpo23;
        this.cpo24 = cpo24;
        this.cpo25 = cpo25;
        this.cpo26 = cpo26;
        this.cpo27 = cpo27;
        this.cpo28 = cpo28;
    }

    protected MennuResumo(Parcel in) {
        id = in.readLong();
        cpo01 = in.readString();
        cpo02 = in.readString();
        cpo03 = in.readString();
        cpo04 = in.readString();
        cpo05 = in.readString();
        cpo06 = in.readString();
        cpo07 = in.readString();
        cpo08 = in.readString();
        cpo09 = in.readString();
        cpo10 = in.readString();
        cpo11 = in.readString();
        cpo12 = in.readString();
        cpo13 = in.readString();
        cpo14 = in.readString();
        cpo15 = in.readString();
        cpo16 = in.readString();
        cpo17 = in.readString();
        cpo18 = in.readString();
        cpo19 = in.readString();
        cpo20 = in.readString();
        cpo21 = in.readString();
        cpo22 = in.readString();
        cpo23 = in.readString();
        cpo24 = in.readString();
        cpo25 = in.readString();
        cpo26 = in.readString();
        cpo27 = in.readString();
        cpo28 = in.readString();
    }

    public static final Creator<MennuResumo> CREATOR = new Creator<MennuResumo>() {
        @Override
        public MennuResumo createFromParcel(Parcel in) {
            return new MennuResumo(in);
        }

        @Override
        public MennuResumo[] newArray(int size) {
            return new MennuResumo[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpo01() {
        return cpo01;
    }

    public void setCpo01(String cpo01) {
        this.cpo01 = cpo01;
    }

    public String getCpo02() {
        return cpo02;
    }

    public void setCpo02(String cpo02) {
        this.cpo02 = cpo02;
    }

    public String getCpo03() {
        return cpo03;
    }

    public void setCpo03(String cpo03) {
        this.cpo03 = cpo03;
    }

    public String getCpo04() {
        return cpo04;
    }

    public void setCpo04(String cpo04) {
        this.cpo04 = cpo04;
    }

    public String getCpo05() {
        return cpo05;
    }

    public void setCpo05(String cpo05) {
        this.cpo05 = cpo05;
    }

    public String getCpo06() {
        return cpo06;
    }

    public void setCpo06(String cpo06) {
        this.cpo06 = cpo06;
    }

    public String getCpo07() {
        return cpo07;
    }

    public void setCpo07(String cpo07) {
        this.cpo07 = cpo07;
    }

    public String getCpo08() {
        return cpo08;
    }

    public void setCpo08(String cpo08) {
        this.cpo08 = cpo08;
    }

    public String getCpo09() {
        return cpo09;
    }

    public void setCpo09(String cpo09) {
        this.cpo09 = cpo09;
    }

    public String getCpo10() {
        return cpo10;
    }

    public void setCpo10(String cpo10) {
        this.cpo10 = cpo10;
    }

    public String getCpo11() {
        return cpo11;
    }

    public void setCpo11(String cpo11) {
        this.cpo11 = cpo11;
    }

    public String getCpo12() {
        return cpo12;
    }

    public void setCpo12(String cpo12) {
        this.cpo12 = cpo12;
    }

    public String getCpo13() {
        return cpo13;
    }

    public void setCpo13(String cpo13) {
        this.cpo13 = cpo13;
    }

    public String getCpo14() {
        return cpo14;
    }

    public void setCpo14(String cpo14) {
        this.cpo14 = cpo14;
    }

    public String getCpo15() {
        return cpo15;
    }

    public void setCpo15(String cpo15) {
        this.cpo15 = cpo15;
    }

    public String getCpo16() {
        return cpo16;
    }

    public void setCpo16(String cpo16) {
        this.cpo16 = cpo16;
    }

    public String getCpo17() {
        return cpo17;
    }

    public void setCpo17(String cpo17) {
        this.cpo17 = cpo17;
    }

    public String getCpo18() {
        return cpo18;
    }

    public void setCpo18(String cpo18) {
        this.cpo18 = cpo18;
    }

    public String getCpo19() {
        return cpo19;
    }

    public void setCpo19(String cpo19) {
        this.cpo19 = cpo19;
    }

    public String getCpo20() {
        return cpo20;
    }

    public void setCpo20(String cpo20) {
        this.cpo20 = cpo20;
    }

    public String getCpo21() {
        return cpo21;
    }

    public void setCpo21(String cpo21) {
        this.cpo21 = cpo21;
    }

    public String getCpo22() {
        return cpo22;
    }

    public void setCpo22(String cpo22) {
        this.cpo22 = cpo22;
    }

    public String getCpo23() {
        return cpo23;
    }

    public void setCpo23(String cpo23) {
        this.cpo23 = cpo23;
    }

    public String getCpo24() {
        return cpo24;
    }

    public void setCpo24(String cpo24) {
        this.cpo24 = cpo24;
    }

    public String getCpo25() {
        return cpo25;
    }

    public void setCpo25(String cpo25) {
        this.cpo25 = cpo25;
    }

    public String getCpo26() {
        return cpo26;
    }

    public void setCpo26(String cpo26) {
        this.cpo26 = cpo26;
    }

    public String getCpo27() {
        return cpo27;
    }

    public void setCpo27(String cpo27) {
        this.cpo27 = cpo27;
    }

    public String getCpo28() {
        return cpo28;
    }

    public void setCpo28(String cpo28) {
        this.cpo28 = cpo28;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(cpo01);
        dest.writeString(cpo02);
        dest.writeString(cpo03);
        dest.writeString(cpo04);
        dest.writeString(cpo05);
        dest.writeString(cpo06);
        dest.writeString(cpo07);
        dest.writeString(cpo08);
        dest.writeString(cpo09);
        dest.writeString(cpo10);
        dest.writeString(cpo11);
        dest.writeString(cpo12);
        dest.writeString(cpo13);
        dest.writeString(cpo14);
        dest.writeString(cpo15);
        dest.writeString(cpo16);
        dest.writeString(cpo17);
        dest.writeString(cpo18);
        dest.writeString(cpo19);
        dest.writeString(cpo20);
        dest.writeString(cpo21);
        dest.writeString(cpo22);
        dest.writeString(cpo23);
        dest.writeString(cpo24);
        dest.writeString(cpo25);
        dest.writeString(cpo26);
        dest.writeString(cpo27);
        dest.writeString(cpo28);
    }
}
