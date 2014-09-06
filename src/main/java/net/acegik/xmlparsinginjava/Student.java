package net.acegik.xmlparsinginjava;

/**
 *
 * @author pnhung177
 */
public class Student {
    private String id;
    private String fullname;
    private String email;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("id:").append("\"").append(id).append("\"").append(",");
        sb.append("fullname:").append("\"").append(fullname).append("\"").append(",");
        sb.append("email:").append("\"").append(email).append("\"").append(",");
        sb.append("address:").append("\"").append(address).append("\"");
        sb.append("}");
        return sb.toString();
    }
}
