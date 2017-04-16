package org.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by jzchen on 2017/1/11 0011.
 */
@MappedSuperclass
public class CoreBase implements Serializable{

    private Integer id = null;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
//        if(id == null) {
//            id = UUID.randomUUID().toString().replace("-","");
//        }
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
