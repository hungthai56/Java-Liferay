/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package thuvien.porlet.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import thuvien.porlet.model.Sach;
import thuvien.porlet.model.SachModel;
import thuvien.porlet.model.SachSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Sach service. Represents a row in the &quot;sach&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link thuvien.porlet.model.SachModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SachImpl}.
 * </p>
 *
 * @author HungThai
 * @see SachImpl
 * @see thuvien.porlet.model.Sach
 * @see thuvien.porlet.model.SachModel
 * @generated
 */
@JSON(strict = true)
public class SachModelImpl extends BaseModelImpl<Sach> implements SachModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sach model instance should use the {@link thuvien.porlet.model.Sach} interface instead.
	 */
	public static final String TABLE_NAME = "sach";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "tensach", Types.VARCHAR },
			{ "theloaiid", Types.BIGINT },
			{ "soluong", Types.BIGINT },
			{ "trangthai", Types.VARCHAR },
			{ "nhaxb", Types.VARCHAR },
			{ "masach", Types.VARCHAR },
			{ "ke", Types.VARCHAR },
			{ "tang", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table sach (id LONG not null primary key,tensach VARCHAR(75) null,theloaiid LONG,soluong LONG,trangthai VARCHAR(75) null,nhaxb VARCHAR(75) null,masach VARCHAR(75) null,ke VARCHAR(75) null,tang VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table sach";
	public static final String ORDER_BY_JPQL = " ORDER BY sach.Id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY sach.id ASC";
	public static final String DATA_SOURCE = "qlthuvienDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.thuvien.porlet.model.Sach"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.thuvien.porlet.model.Sach"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Sach toModel(SachSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Sach model = new SachImpl();

		model.setId(soapModel.getId());
		model.setTenSach(soapModel.getTenSach());
		model.setTheLoaiId(soapModel.getTheLoaiId());
		model.setSoLuong(soapModel.getSoLuong());
		model.setTrangThai(soapModel.getTrangThai());
		model.setNhaXB(soapModel.getNhaXB());
		model.setMaSach(soapModel.getMaSach());
		model.setKe(soapModel.getKe());
		model.setTang(soapModel.getTang());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Sach> toModels(SachSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Sach> models = new ArrayList<Sach>(soapModels.length);

		for (SachSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.thuvien.porlet.model.Sach"));

	public SachModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _Id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _Id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Sach.class;
	}

	@Override
	public String getModelClassName() {
		return Sach.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("Id", getId());
		attributes.put("TenSach", getTenSach());
		attributes.put("TheLoaiId", getTheLoaiId());
		attributes.put("SoLuong", getSoLuong());
		attributes.put("TrangThai", getTrangThai());
		attributes.put("NhaXB", getNhaXB());
		attributes.put("MaSach", getMaSach());
		attributes.put("Ke", getKe());
		attributes.put("Tang", getTang());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long Id = (Long)attributes.get("Id");

		if (Id != null) {
			setId(Id);
		}

		String TenSach = (String)attributes.get("TenSach");

		if (TenSach != null) {
			setTenSach(TenSach);
		}

		Long TheLoaiId = (Long)attributes.get("TheLoaiId");

		if (TheLoaiId != null) {
			setTheLoaiId(TheLoaiId);
		}

		Long SoLuong = (Long)attributes.get("SoLuong");

		if (SoLuong != null) {
			setSoLuong(SoLuong);
		}

		String TrangThai = (String)attributes.get("TrangThai");

		if (TrangThai != null) {
			setTrangThai(TrangThai);
		}

		String NhaXB = (String)attributes.get("NhaXB");

		if (NhaXB != null) {
			setNhaXB(NhaXB);
		}

		String MaSach = (String)attributes.get("MaSach");

		if (MaSach != null) {
			setMaSach(MaSach);
		}

		String Ke = (String)attributes.get("Ke");

		if (Ke != null) {
			setKe(Ke);
		}

		String Tang = (String)attributes.get("Tang");

		if (Tang != null) {
			setTang(Tang);
		}
	}

	@JSON
	@Override
	public long getId() {
		return _Id;
	}

	@Override
	public void setId(long Id) {
		_Id = Id;
	}

	@JSON
	@Override
	public String getTenSach() {
		if (_TenSach == null) {
			return StringPool.BLANK;
		}
		else {
			return _TenSach;
		}
	}

	@Override
	public void setTenSach(String TenSach) {
		_TenSach = TenSach;
	}

	@JSON
	@Override
	public long getTheLoaiId() {
		return _TheLoaiId;
	}

	@Override
	public void setTheLoaiId(long TheLoaiId) {
		_TheLoaiId = TheLoaiId;
	}

	@JSON
	@Override
	public long getSoLuong() {
		return _SoLuong;
	}

	@Override
	public void setSoLuong(long SoLuong) {
		_SoLuong = SoLuong;
	}

	@JSON
	@Override
	public String getTrangThai() {
		if (_TrangThai == null) {
			return StringPool.BLANK;
		}
		else {
			return _TrangThai;
		}
	}

	@Override
	public void setTrangThai(String TrangThai) {
		_TrangThai = TrangThai;
	}

	@JSON
	@Override
	public String getNhaXB() {
		if (_NhaXB == null) {
			return StringPool.BLANK;
		}
		else {
			return _NhaXB;
		}
	}

	@Override
	public void setNhaXB(String NhaXB) {
		_NhaXB = NhaXB;
	}

	@JSON
	@Override
	public String getMaSach() {
		if (_MaSach == null) {
			return StringPool.BLANK;
		}
		else {
			return _MaSach;
		}
	}

	@Override
	public void setMaSach(String MaSach) {
		_MaSach = MaSach;
	}

	@JSON
	@Override
	public String getKe() {
		if (_Ke == null) {
			return StringPool.BLANK;
		}
		else {
			return _Ke;
		}
	}

	@Override
	public void setKe(String Ke) {
		_Ke = Ke;
	}

	@JSON
	@Override
	public String getTang() {
		if (_Tang == null) {
			return StringPool.BLANK;
		}
		else {
			return _Tang;
		}
	}

	@Override
	public void setTang(String Tang) {
		_Tang = Tang;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Sach.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Sach toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Sach)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SachImpl sachImpl = new SachImpl();

		sachImpl.setId(getId());
		sachImpl.setTenSach(getTenSach());
		sachImpl.setTheLoaiId(getTheLoaiId());
		sachImpl.setSoLuong(getSoLuong());
		sachImpl.setTrangThai(getTrangThai());
		sachImpl.setNhaXB(getNhaXB());
		sachImpl.setMaSach(getMaSach());
		sachImpl.setKe(getKe());
		sachImpl.setTang(getTang());

		sachImpl.resetOriginalValues();

		return sachImpl;
	}

	@Override
	public int compareTo(Sach sach) {
		long primaryKey = sach.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Sach)) {
			return false;
		}

		Sach sach = (Sach)obj;

		long primaryKey = sach.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Sach> toCacheModel() {
		SachCacheModel sachCacheModel = new SachCacheModel();

		sachCacheModel.Id = getId();

		sachCacheModel.TenSach = getTenSach();

		String TenSach = sachCacheModel.TenSach;

		if ((TenSach != null) && (TenSach.length() == 0)) {
			sachCacheModel.TenSach = null;
		}

		sachCacheModel.TheLoaiId = getTheLoaiId();

		sachCacheModel.SoLuong = getSoLuong();

		sachCacheModel.TrangThai = getTrangThai();

		String TrangThai = sachCacheModel.TrangThai;

		if ((TrangThai != null) && (TrangThai.length() == 0)) {
			sachCacheModel.TrangThai = null;
		}

		sachCacheModel.NhaXB = getNhaXB();

		String NhaXB = sachCacheModel.NhaXB;

		if ((NhaXB != null) && (NhaXB.length() == 0)) {
			sachCacheModel.NhaXB = null;
		}

		sachCacheModel.MaSach = getMaSach();

		String MaSach = sachCacheModel.MaSach;

		if ((MaSach != null) && (MaSach.length() == 0)) {
			sachCacheModel.MaSach = null;
		}

		sachCacheModel.Ke = getKe();

		String Ke = sachCacheModel.Ke;

		if ((Ke != null) && (Ke.length() == 0)) {
			sachCacheModel.Ke = null;
		}

		sachCacheModel.Tang = getTang();

		String Tang = sachCacheModel.Tang;

		if ((Tang != null) && (Tang.length() == 0)) {
			sachCacheModel.Tang = null;
		}

		return sachCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{Id=");
		sb.append(getId());
		sb.append(", TenSach=");
		sb.append(getTenSach());
		sb.append(", TheLoaiId=");
		sb.append(getTheLoaiId());
		sb.append(", SoLuong=");
		sb.append(getSoLuong());
		sb.append(", TrangThai=");
		sb.append(getTrangThai());
		sb.append(", NhaXB=");
		sb.append(getNhaXB());
		sb.append(", MaSach=");
		sb.append(getMaSach());
		sb.append(", Ke=");
		sb.append(getKe());
		sb.append(", Tang=");
		sb.append(getTang());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("thuvien.porlet.model.Sach");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>Id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TenSach</column-name><column-value><![CDATA[");
		sb.append(getTenSach());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TheLoaiId</column-name><column-value><![CDATA[");
		sb.append(getTheLoaiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SoLuong</column-name><column-value><![CDATA[");
		sb.append(getSoLuong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TrangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NhaXB</column-name><column-value><![CDATA[");
		sb.append(getNhaXB());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MaSach</column-name><column-value><![CDATA[");
		sb.append(getMaSach());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Ke</column-name><column-value><![CDATA[");
		sb.append(getKe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Tang</column-name><column-value><![CDATA[");
		sb.append(getTang());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Sach.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Sach.class };
	private long _Id;
	private String _TenSach;
	private long _TheLoaiId;
	private long _SoLuong;
	private String _TrangThai;
	private String _NhaXB;
	private String _MaSach;
	private String _Ke;
	private String _Tang;
	private Sach _escapedModel;
}