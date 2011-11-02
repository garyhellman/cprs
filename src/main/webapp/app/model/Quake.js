Ext.define('CPRS.model.Quake' ,{
    extend: 'Ext.data.Model',
	fields: [
	   {name: 'fid', type: 'int'},
	   {name: 'title', type: 'string'},
	   {name: 'description', type: 'string'},
	   {name: 'link', type: 'string'},
	   {name: 'pubDate', type: 'date'},
	   {name: 'lat', type: 'string'},
	   {name: 'long', type: 'string'}
	],
	idProperty: 'fid'
});
	
