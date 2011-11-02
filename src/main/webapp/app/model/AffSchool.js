Ext.define('CPRS.model.AffSchool', {
	extend: 'Ext.data.Model',
	fields: [ {name: 'id', type: 'int'},
			  {name: 'name', type: 'string'}
			 ]
	//,

//	proxy: {
//		type: 'direct',
//		directFn: userService.loadAllRoles
//	}
});