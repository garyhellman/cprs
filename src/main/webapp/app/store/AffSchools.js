Ext.define('CPRS.store.AffSchools' ,{
    extend: 'Ext.data.AffStore',
    model: 'CPRS.model.AffSchool',
    autoLoad: true,
	data: [
	{id: 1, name: 'ADMIN'},
	{id: 2 , name: 'USER'}
	]
    
});
