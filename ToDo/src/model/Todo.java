package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TODO database table.
 * 
 */
@Entity
@Table(name="TODO", schema="TESTDB")
@NamedQuery(name="Todo.findAll", query="SELECT t FROM Todo t")
public class Todo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long tid;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date duedate;

	private String status;

	private String title;

	private int tpriority;

	//bi-directional many-to-one association to Tuser
	@ManyToOne
	@JoinColumn(name="USERID")
	private Tuser tuser;

	public Todo() {
	}

	public long getTid() {
		return this.tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDuedate() {
		return this.duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTpriority() {
		return this.tpriority;
	}

	public void setTpriority(int tpriority) {
		this.tpriority = tpriority;
	}

	public Tuser getTuser() {
		return this.tuser;
	}

	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}

}