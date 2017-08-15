package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela USERROLE
 * @generated
 */
@Entity
@Table(name = "\"USERROLE\"")
@XmlRootElement
@CronappSecurity(get = "Administrators", post = "Administrators", put = "Administrators", delete = "Administrators")
@JsonFilter("app.entity.UserRole")
public class UserRole implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "id", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  private User user;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_role", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  private Role role;

  /**
   * Construtor
   * @generated
   */
  public UserRole(){
  }


  /**
   * Obtém id
   * return id
   * @generated
   */
  public java.lang.String getId(){
    return this.id;
  }

  /**
   * Define id
   * @param id id
   * @generated
   */
  public UserRole setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém user
   * return user
   * @generated
   */
  public User getUser(){
    return this.user;
  }

  /**
   * Define user
   * @param user user
   * @generated
   */
  public UserRole setUser(User user){
    this.user = user;
    return this;
  }

  /**
   * Obtém role
   * return role
   * @generated
   */
  public Role getRole(){
    return this.role;
  }

  /**
   * Define role
   * @param role role
   * @generated
   */
  public UserRole setRole(Role role){
    this.role = role;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    UserRole object = (UserRole)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}