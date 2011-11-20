// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.sun.demo.addressbook;

import com.sun.demo.addressbook.DomainAddress;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect DomainAddress_Roo_Entity {
    
    declare @type: DomainAddress: @Entity;
    
    @PersistenceContext
    transient EntityManager DomainAddress.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long DomainAddress.id;
    
    @Version
    @Column(name = "version")
    private Integer DomainAddress.version;
    
    public Long DomainAddress.getId() {
        return this.id;
    }
    
    public void DomainAddress.setId(Long id) {
        this.id = id;
    }
    
    public Integer DomainAddress.getVersion() {
        return this.version;
    }
    
    public void DomainAddress.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void DomainAddress.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void DomainAddress.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            DomainAddress attached = DomainAddress.findDomainAddress(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void DomainAddress.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void DomainAddress.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public DomainAddress DomainAddress.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        DomainAddress merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager DomainAddress.entityManager() {
        EntityManager em = new DomainAddress().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long DomainAddress.countDomainAddresses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM DomainAddress o", Long.class).getSingleResult();
    }
    
    public static List<DomainAddress> DomainAddress.findAllDomainAddresses() {
        return entityManager().createQuery("SELECT o FROM DomainAddress o", DomainAddress.class).getResultList();
    }
    
    public static DomainAddress DomainAddress.findDomainAddress(Long id) {
        if (id == null) return null;
        return entityManager().find(DomainAddress.class, id);
    }
    
    public static List<DomainAddress> DomainAddress.findDomainAddressEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM DomainAddress o", DomainAddress.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
