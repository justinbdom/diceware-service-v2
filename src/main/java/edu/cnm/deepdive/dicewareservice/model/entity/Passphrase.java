package edu.cnm.deepdive.dicewareservice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Passphrase {

  private static EntityLinks links;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "passphrase_id", updatable = false, nullable = false)
  private Long id;

  @NonNull
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date created;

  @JsonIgnore
  @NonNull
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", nullable = false, updatable = false)
  private User user;

  @NonNull
  @Column(name = "passkey", nullable = false, length = 20, unique = true)
  @Pattern(regexp = "^\\D.*")
  private String key;

  @OneToMany(mappedBy = "passphrase", cascade = CascadeType.ALL, orphanRemoval = true)
  @OrderBy("word_id ASC")
  private List<Word> words = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public Date getCreated() {
    return created;
  }

  @NonNull
  public User getUser() {
    return user;
  }

  public void setUser(@NonNull User user) {
    this.user = user;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public List<Word> getWords() {
    return words;
  }

  public URI getHref() {
    return links.linkForSingleResource(Passphrase.class, id).toUri();
  }

  @PostConstruct
  private void initLinks() {
    String ignore = links.toString();
  }

  @Autowired
  public void setLinks(EntityLinks links) {
    Passphrase.links = links;
  }

}
