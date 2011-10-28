Ext.define('CPRS.store.Users', {
	extend: 'Ext.data.Store',
	model: 'CPRS.model.User',
	autoLoad: false,
	remoteSort: true,
	pageSize: 30,
	autoSync: false,
	sorters: [ {
		property: 'name',
		direction: 'ASC'
	} ]
});