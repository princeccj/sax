package cn.lbw.sax;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import cn.lbw.dbutil.DBConnector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import cn.lbw.entity.DBLPInfo;

/**
 * Created by Bowei Liu on 2017/10/18.
 */
public class SAXParserHandler extends DefaultHandler {
	static Connection conn = DBConnector.getConn();
	static PreparedStatement ps = null;
	static int index = 0;
	static int DBLPIndex = 0;
	static DBLPInfo dblp = null;
	String value = null;
	boolean isEnd = false;
	StringBuffer sb = new StringBuffer();
	public static Set<String> types = new HashSet<String>();
	static {
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("insert into DBLP("
						+ "dblp_type, dblp_authors, dblp_title, dblp_year,dblp_mdate,dblp_key,dblp_pages,dblp_volume,dblp_journal,dblp_number,dblp_ee,dblp_url) VALUES ( ?, ?, ?, ? , ? , ? ,? ,? ,? ,? ,? ,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		types.add("article");
		types.add("inproceedings");
		types.add("proceedings");
		types.add("book");
		types.add("incollection");
		types.add("phdthesis");
		types.add("mastersthesis");
		types.add("www");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		sb.delete(0,sb.length());
		if(types.contains(qName)) {
			dblp = new DBLPInfo();
			isEnd = false;
			dblp.setDblp_type(qName);
			dblp.setDblp_mdate(attributes.getValue(0));
			dblp.setDblp_key(attributes.getValue(1));
		}
	}
	

	@Override
	public void endElement(String uri, String localName, String name) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, name);
		if(name.equals("dblp")){
			try {
				ps.executeBatch();
				conn.commit();
				index++;
				System.out.println(index);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			appendMethodB("",dblp);
			System.out.println("最后一批数据写入");
		}else if(types.contains(name)){
			isEnd = true;
			DBLPIndex++;
			try {
				ps.setString(1, dblp.getDblp_type());
				ps.setString(2, dblp.getDblp_authors());
				ps.setString(3, dblp.getDblp_title());
				ps.setString(4, dblp.getDblp_year());
				ps.setString(5, dblp.getDblp_mdate());
				ps.setString(6, dblp.getDblp_key());
				ps.setString(7, dblp.getDblp_pages());
				ps.setString(8, dblp.getDblp_volume());
				ps.setString(9, dblp.getDblp_journal());
				ps.setString(10, dblp.getDblp_number());
				ps.setString(11, dblp.getDblp_ee());
				ps.setString(12, dblp.getDblp_url());
				ps.addBatch();
				if (DBLPIndex%20000 == 0){
					System.out.println(DBLPIndex);
					ps.executeBatch();
					conn.commit();

				}
//			appendMethodB("",dblp);
			} catch (SQLException e) {
				System.out.println("写入数据错误！");
				e.printStackTrace();
			}
		}else if (name.equals("author") && isEnd ==false) {
			if (dblp.getDblp_authors().equals("")){
				dblp.setDblp_authors(value);
			}else
				dblp.setDblp_authors(dblp.getDblp_authors()+","+value);
		}else if ( (name.equals("title")||name.equals("booktitle") ) && isEnd ==false) {
			dblp.setDblp_title(value);
		}else if (name.equals("year") && isEnd ==false) {
			dblp.setDblp_year(value);
		}else if (name.equals("mdate") && isEnd ==false) {
			dblp.setDblp_mdate(value);
		}else if (name.equals("key") && isEnd ==false) {
			dblp.setDblp_key(value);
		}else if (name.equals("pages") && isEnd ==false) {
			dblp.setDblp_pages(value);
		}else if (name.equals("volume") && isEnd ==false) {
			dblp.setDblp_volume(value);
		}else if (name.equals("journal") && isEnd ==false) {
			dblp.setDblp_journal(value);
		}else if (name.equals("number") && isEnd ==false) {
			dblp.setDblp_number(value);
		}else if (name.equals("ee") && isEnd ==false) {
			dblp.setDblp_ee(value);
		}else if (name.equals("url") && isEnd ==false) {
			dblp.setDblp_url(value);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		sb.append(ch,start,length);//字符相加
		value =sb.toString();
	}
	

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("开始！");
	}
	

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("结束！");
	}

	public static void appendMethodB(String fileName, DBLPInfo dblp) {


		try {
			String content = dblp.getDblp_type()+"\t"+dblp.getDblp_authors()+"\t"+dblp.getDblp_title()+"\t"+dblp.getDblp_journal()+"\t"+dblp.getDblp_mdate()+"\t"+dblp.getDblp_key()+"\t"+dblp.getDblp_year()+"\t"+dblp.getDblp_volume()+"\t"+dblp.getDblp_pages()+"\t"+dblp.getDblp_ee()+"\t"+dblp.getDblp_number()+"\t"+dblp.getDblp_url();
			//打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
			FileWriter writer = new FileWriter(fileName, true);
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
