// JavaScript Document
Ext.define("EarmarkApp.store.Earmarks", {
	extend: 'Ext.data.Store',
	buffered: true,
	model: 'EarmarkApp.model.Earmark',
	autoLoad: false,
	remoteFilter: true,
	remoteSort: true,
	groupField: 'AGENCY_TITLE',
	pageSize: 100,
	proxy: {
		type: 'scripttag',
		url: 'http://www.senchatraining.com/ftextjs4/webservices/earmark.cfc?method=wsbigJSONP',
		reader: {
			type: 'json',
			root: 'ROWS',
    	    totalProperty: 'RESULTS',
			successProperty: 'SUCCESS'
		}
    }
});



