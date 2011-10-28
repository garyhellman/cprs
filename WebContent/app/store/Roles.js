Ext.define('CPRS.store.Roles', {
	extend: 'Ext.data.Store',
	model: 'CPRS.model.Role',
	autoLoad: true,
	data: [
	{id: 1, name: 'ADMIN'},
	{id: 2 , name: 'USER'}
	]
});