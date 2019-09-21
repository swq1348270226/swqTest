package com.swq.BlogSystem.pojo;

public class Cart {
	private String  id;
	private String  user_id;
	private String  item_id;
	private String  item_title;
	private String  item_image;
	private String  item_price;
	private String  num;
	private String  create_time;
	private String  update_time;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getItem_title() {
		return item_title;
	}
	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}
	public String getItem_image() {
		return item_image;
	}
	public void setItem_image(String item_image) {
		this.item_image = item_image;
	}
	public String getItem_price() {
		return item_price;
	}
	public void setItem_price(String item_price) {
		this.item_price = item_price;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((create_time == null) ? 0 : create_time.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		result = prime * result + ((item_image == null) ? 0 : item_image.hashCode());
		result = prime * result + ((item_price == null) ? 0 : item_price.hashCode());
		result = prime * result + ((item_title == null) ? 0 : item_title.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((update_time == null) ? 0 : update_time.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (create_time == null) {
			if (other.create_time != null)
				return false;
		} else if (!create_time.equals(other.create_time))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;
		if (item_image == null) {
			if (other.item_image != null)
				return false;
		} else if (!item_image.equals(other.item_image))
			return false;
		if (item_price == null) {
			if (other.item_price != null)
				return false;
		} else if (!item_price.equals(other.item_price))
			return false;
		if (item_title == null) {
			if (other.item_title != null)
				return false;
		} else if (!item_title.equals(other.item_title))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		if (update_time == null) {
			if (other.update_time != null)
				return false;
		} else if (!update_time.equals(other.update_time))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "cart [id=" + id + ", user_id=" + user_id + ", item_id=" + item_id + ", item_title=" + item_title
				+ ", item_image=" + item_image + ", item_price=" + item_price + ", num=" + num + ", create_time="
				+ create_time + ", update_time=" + update_time + "]";
	}
	
	
}
