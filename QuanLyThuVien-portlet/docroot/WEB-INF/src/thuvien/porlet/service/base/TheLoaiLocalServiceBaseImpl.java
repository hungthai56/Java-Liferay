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

package thuvien.porlet.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import thuvien.porlet.model.TheLoai;

import thuvien.porlet.service.TheLoaiLocalService;
import thuvien.porlet.service.persistence.PhieuMuonPersistence;
import thuvien.porlet.service.persistence.SachPersistence;
import thuvien.porlet.service.persistence.TheLoaiPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the the loai local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link thuvien.porlet.service.impl.TheLoaiLocalServiceImpl}.
 * </p>
 *
 * @author HungThai
 * @see thuvien.porlet.service.impl.TheLoaiLocalServiceImpl
 * @see thuvien.porlet.service.TheLoaiLocalServiceUtil
 * @generated
 */
public abstract class TheLoaiLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements TheLoaiLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link thuvien.porlet.service.TheLoaiLocalServiceUtil} to access the the loai local service.
	 */

	/**
	 * Adds the the loai to the database. Also notifies the appropriate model listeners.
	 *
	 * @param theLoai the the loai
	 * @return the the loai that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TheLoai addTheLoai(TheLoai theLoai) throws SystemException {
		theLoai.setNew(true);

		return theLoaiPersistence.update(theLoai);
	}

	/**
	 * Creates a new the loai with the primary key. Does not add the the loai to the database.
	 *
	 * @param Id the primary key for the new the loai
	 * @return the new the loai
	 */
	@Override
	public TheLoai createTheLoai(long Id) {
		return theLoaiPersistence.create(Id);
	}

	/**
	 * Deletes the the loai with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the the loai
	 * @return the the loai that was removed
	 * @throws PortalException if a the loai with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TheLoai deleteTheLoai(long Id)
		throws PortalException, SystemException {
		return theLoaiPersistence.remove(Id);
	}

	/**
	 * Deletes the the loai from the database. Also notifies the appropriate model listeners.
	 *
	 * @param theLoai the the loai
	 * @return the the loai that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TheLoai deleteTheLoai(TheLoai theLoai) throws SystemException {
		return theLoaiPersistence.remove(theLoai);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(TheLoai.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return theLoaiPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link thuvien.porlet.model.impl.TheLoaiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return theLoaiPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link thuvien.porlet.model.impl.TheLoaiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return theLoaiPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return theLoaiPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return theLoaiPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public TheLoai fetchTheLoai(long Id) throws SystemException {
		return theLoaiPersistence.fetchByPrimaryKey(Id);
	}

	/**
	 * Returns the the loai with the primary key.
	 *
	 * @param Id the primary key of the the loai
	 * @return the the loai
	 * @throws PortalException if a the loai with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TheLoai getTheLoai(long Id) throws PortalException, SystemException {
		return theLoaiPersistence.findByPrimaryKey(Id);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return theLoaiPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the the loais.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link thuvien.porlet.model.impl.TheLoaiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of the loais
	 * @param end the upper bound of the range of the loais (not inclusive)
	 * @return the range of the loais
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TheLoai> getTheLoais(int start, int end)
		throws SystemException {
		return theLoaiPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of the loais.
	 *
	 * @return the number of the loais
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getTheLoaisCount() throws SystemException {
		return theLoaiPersistence.countAll();
	}

	/**
	 * Updates the the loai in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param theLoai the the loai
	 * @return the the loai that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TheLoai updateTheLoai(TheLoai theLoai) throws SystemException {
		return theLoaiPersistence.update(theLoai);
	}

	/**
	 * Returns the phieu muon local service.
	 *
	 * @return the phieu muon local service
	 */
	public thuvien.porlet.service.PhieuMuonLocalService getPhieuMuonLocalService() {
		return phieuMuonLocalService;
	}

	/**
	 * Sets the phieu muon local service.
	 *
	 * @param phieuMuonLocalService the phieu muon local service
	 */
	public void setPhieuMuonLocalService(
		thuvien.porlet.service.PhieuMuonLocalService phieuMuonLocalService) {
		this.phieuMuonLocalService = phieuMuonLocalService;
	}

	/**
	 * Returns the phieu muon remote service.
	 *
	 * @return the phieu muon remote service
	 */
	public thuvien.porlet.service.PhieuMuonService getPhieuMuonService() {
		return phieuMuonService;
	}

	/**
	 * Sets the phieu muon remote service.
	 *
	 * @param phieuMuonService the phieu muon remote service
	 */
	public void setPhieuMuonService(
		thuvien.porlet.service.PhieuMuonService phieuMuonService) {
		this.phieuMuonService = phieuMuonService;
	}

	/**
	 * Returns the phieu muon persistence.
	 *
	 * @return the phieu muon persistence
	 */
	public PhieuMuonPersistence getPhieuMuonPersistence() {
		return phieuMuonPersistence;
	}

	/**
	 * Sets the phieu muon persistence.
	 *
	 * @param phieuMuonPersistence the phieu muon persistence
	 */
	public void setPhieuMuonPersistence(
		PhieuMuonPersistence phieuMuonPersistence) {
		this.phieuMuonPersistence = phieuMuonPersistence;
	}

	/**
	 * Returns the sach local service.
	 *
	 * @return the sach local service
	 */
	public thuvien.porlet.service.SachLocalService getSachLocalService() {
		return sachLocalService;
	}

	/**
	 * Sets the sach local service.
	 *
	 * @param sachLocalService the sach local service
	 */
	public void setSachLocalService(
		thuvien.porlet.service.SachLocalService sachLocalService) {
		this.sachLocalService = sachLocalService;
	}

	/**
	 * Returns the sach remote service.
	 *
	 * @return the sach remote service
	 */
	public thuvien.porlet.service.SachService getSachService() {
		return sachService;
	}

	/**
	 * Sets the sach remote service.
	 *
	 * @param sachService the sach remote service
	 */
	public void setSachService(thuvien.porlet.service.SachService sachService) {
		this.sachService = sachService;
	}

	/**
	 * Returns the sach persistence.
	 *
	 * @return the sach persistence
	 */
	public SachPersistence getSachPersistence() {
		return sachPersistence;
	}

	/**
	 * Sets the sach persistence.
	 *
	 * @param sachPersistence the sach persistence
	 */
	public void setSachPersistence(SachPersistence sachPersistence) {
		this.sachPersistence = sachPersistence;
	}

	/**
	 * Returns the the loai local service.
	 *
	 * @return the the loai local service
	 */
	public thuvien.porlet.service.TheLoaiLocalService getTheLoaiLocalService() {
		return theLoaiLocalService;
	}

	/**
	 * Sets the the loai local service.
	 *
	 * @param theLoaiLocalService the the loai local service
	 */
	public void setTheLoaiLocalService(
		thuvien.porlet.service.TheLoaiLocalService theLoaiLocalService) {
		this.theLoaiLocalService = theLoaiLocalService;
	}

	/**
	 * Returns the the loai remote service.
	 *
	 * @return the the loai remote service
	 */
	public thuvien.porlet.service.TheLoaiService getTheLoaiService() {
		return theLoaiService;
	}

	/**
	 * Sets the the loai remote service.
	 *
	 * @param theLoaiService the the loai remote service
	 */
	public void setTheLoaiService(
		thuvien.porlet.service.TheLoaiService theLoaiService) {
		this.theLoaiService = theLoaiService;
	}

	/**
	 * Returns the the loai persistence.
	 *
	 * @return the the loai persistence
	 */
	public TheLoaiPersistence getTheLoaiPersistence() {
		return theLoaiPersistence;
	}

	/**
	 * Sets the the loai persistence.
	 *
	 * @param theLoaiPersistence the the loai persistence
	 */
	public void setTheLoaiPersistence(TheLoaiPersistence theLoaiPersistence) {
		this.theLoaiPersistence = theLoaiPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("thuvien.porlet.model.TheLoai",
			theLoaiLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"thuvien.porlet.model.TheLoai");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return TheLoai.class;
	}

	protected String getModelClassName() {
		return TheLoai.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = theLoaiPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = thuvien.porlet.service.PhieuMuonLocalService.class)
	protected thuvien.porlet.service.PhieuMuonLocalService phieuMuonLocalService;
	@BeanReference(type = thuvien.porlet.service.PhieuMuonService.class)
	protected thuvien.porlet.service.PhieuMuonService phieuMuonService;
	@BeanReference(type = PhieuMuonPersistence.class)
	protected PhieuMuonPersistence phieuMuonPersistence;
	@BeanReference(type = thuvien.porlet.service.SachLocalService.class)
	protected thuvien.porlet.service.SachLocalService sachLocalService;
	@BeanReference(type = thuvien.porlet.service.SachService.class)
	protected thuvien.porlet.service.SachService sachService;
	@BeanReference(type = SachPersistence.class)
	protected SachPersistence sachPersistence;
	@BeanReference(type = thuvien.porlet.service.TheLoaiLocalService.class)
	protected thuvien.porlet.service.TheLoaiLocalService theLoaiLocalService;
	@BeanReference(type = thuvien.porlet.service.TheLoaiService.class)
	protected thuvien.porlet.service.TheLoaiService theLoaiService;
	@BeanReference(type = TheLoaiPersistence.class)
	protected TheLoaiPersistence theLoaiPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private TheLoaiLocalServiceClpInvoker _clpInvoker = new TheLoaiLocalServiceClpInvoker();
}