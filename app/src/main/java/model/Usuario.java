package model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 30/10/2016.
 */
public class Usuario implements Parcelable {

    private long id;
    private String idUsuario;
    private String login;
    private String nome;
    private String email;
    private String empresa;
    private String conexao;

    public Usuario() {
    }

    public Usuario(String idUsuario, String login, String nome, String email, String empresa, String conexao) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.nome = nome;
        this.email = email;
        this.empresa = empresa;
        this.conexao = conexao;
    }

    public Usuario(long id, String idUsuario, String login, String nome, String email, String empresa, String conexao) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.login = login;
        this.nome = nome;
        this.email = email;
        this.empresa = empresa;
        this.conexao = conexao;
    }

    protected Usuario(Parcel in) {
        id = in.readLong();
        idUsuario = in.readString();
        login = in.readString();
        nome = in.readString();
        email = in.readString();
        empresa = in.readString();
        conexao = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getConexao() {
        return conexao;
    }

    public void setConexao(String conexao) {
        this.conexao = conexao;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(idUsuario);
        dest.writeString(login);
        dest.writeString(nome);
        dest.writeString(email);
        dest.writeString(empresa);
        dest.writeString(conexao);
    }
}
