Ext.define('CPRS.store.Quakes' ,{
    extend: 'Ext.data.Store',
    model: 'CPRS.model.Quake',
    autoLoad: true,
    
    proxy: {
        type: 'jsonp',
        url: 'http://query.yahooapis.com/v1/public/yql',
      extraParams: {
        q: 'select * from rss where url="http://earthquake.usgs.gov/earthquakes/catalogs/eqs7day-M2.5.xml"',
        format: 'json'
      },
      reader: {
	       root: 'query.results.item',
           type: 'json',
	       successProperty: 'success'
      }
    }
});
