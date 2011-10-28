Ext.define('CPRS.store.Doccats', {
	extend: 'Ext.data.Store',
	model: 'CPRS.model.Doccats',
	autoLoad: false,
	remoteSort: true,
	pageSize: 30,
	autoSync: false,
	sorters: [ {
		property: 'name',
		direction: 'ASC'
	} ]
});