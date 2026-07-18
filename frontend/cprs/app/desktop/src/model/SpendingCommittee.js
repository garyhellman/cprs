Ext.define('EarmarkApp.model.SpendingCommittee', {
	extend: 'Ext.data.Model',
	fields: [
	  {name: 'IDSPENDINGCOMMITTEE', type: 'integer'},
	  {name: 'COMMITTEENAME', type: 'string'}
	],
	validations: [
 		{type: 'presence',  field: 'COMMITTEENAME'},
 		{type: 'length',    field: 'COMMITTEENAME',  min: 2}
	],
	hasMany: {model: 'Earmark', name: 'earmarks'},
	
	proxy: {
		type: 'ajax',
		url: 'data/spendingCommittee.json'	
	}
});

