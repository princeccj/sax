package cn.lbw.entity;

/**
 * Created by Bowei Liu on 2017/10/18.
 */
public class DBLPInfo {
	public String dblp_type;
	public String dblp_authors;
	public String dblp_title;
	public String dblp_year;
	public String dblp_mdate;
	public String dblp_key;
	private String dblp_pages;
	private String dblp_volume;
	private String dblp_journal;
	private String dblp_number;
	private String dblp_ee;
	private String dblp_url;

	public DBLPInfo(String dblp_type, String dblp_authors, String dblp_title, String dblp_year, String dblp_mdate, String dblp_key, String dblp_pages, String dblp_volume, String dblp_journal, String dblp_number, String dblp_ee, String dblp_url) {
		this.dblp_type = dblp_type;
		this.dblp_authors = dblp_authors;
		this.dblp_title = dblp_title;
		this.dblp_year = dblp_year;
		this.dblp_mdate = dblp_mdate;
		this.dblp_key = dblp_key;
		this.dblp_pages = dblp_pages;
		this.dblp_volume = dblp_volume;
		this.dblp_journal = dblp_journal;
		this.dblp_number = dblp_number;
		this.dblp_ee = dblp_ee;
		this.dblp_url = dblp_url;
	}

	public DBLPInfo() {
		this.dblp_type = "";
		this.dblp_authors = "";
		this.dblp_title = "";
		this.dblp_year = "";
		this.dblp_mdate = "";
		this.dblp_key = "";
		this.dblp_pages = "";
		this.dblp_volume = "";
		this.dblp_journal = "";
		this.dblp_number = "";
		this.dblp_ee = "";
		this.dblp_url = "";
	}

	public String getDblp_type() {
		return dblp_type;
	}

	public void setDblp_type(String dblp_type) {
		this.dblp_type = dblp_type;
	}

	public String getDblp_authors() {
		return dblp_authors;
	}

	public void setDblp_authors(String dblp_authors) {
		this.dblp_authors = dblp_authors;
	}

	public String getDblp_title() {
		return dblp_title;
	}

	public void setDblp_title(String dblp_title) {
		this.dblp_title = dblp_title;
	}

	public String getDblp_year() {
		return dblp_year;
	}

	public void setDblp_year(String dblp_year) {
		this.dblp_year = dblp_year;
	}

	public String getDblp_mdate() {
		return dblp_mdate;
	}

	public void setDblp_mdate(String dblp_mdate) {
		this.dblp_mdate = dblp_mdate;
	}

	public String getDblp_key() {
		return dblp_key;
	}

	public void setDblp_key(String dblp_key) {
		this.dblp_key = dblp_key;
	}

	public String getDblp_pages() {
		return dblp_pages;
	}

	public void setDblp_pages(String dblp_pages) {
		this.dblp_pages = dblp_pages;
	}

	public String getDblp_volume() {
		return dblp_volume;
	}

	public void setDblp_volume(String dblp_volume) {
		this.dblp_volume = dblp_volume;
	}

	public String getDblp_journal() {
		return dblp_journal;
	}

	public void setDblp_journal(String dblp_journal) {
		this.dblp_journal = dblp_journal;
	}

	public String getDblp_number() {
		return dblp_number;
	}

	public void setDblp_number(String dblp_number) {
		this.dblp_number = dblp_number;
	}

	public String getDblp_ee() {
		return dblp_ee;
	}

	public void setDblp_ee(String dblp_ee) {
		this.dblp_ee = dblp_ee;
	}

	public String getDblp_url() {
		return dblp_url;
	}

	public void setDblp_url(String dblp_url) {
		this.dblp_url = dblp_url;
	}
}
