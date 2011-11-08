Ext.define('CPRS.model.AffSchool', {
	extend: 'Ext.data.Model',
	fields: [ 
	          'value'
			 ],
	belongsTo: 'CPRS.model.Reviewer'
			 
	//,

//	proxy: {
//		type: 'direct',
//		directFn: userService.loadAllRoles
//	}
});