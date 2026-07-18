Ext.define("EarmarkApp.store.Sponsors", {
	extend: 'Ext.data.Store',
	model: 'EarmarkApp.model.Sponsor',
	autoLoad: true,
	pageSize: 1000
});

