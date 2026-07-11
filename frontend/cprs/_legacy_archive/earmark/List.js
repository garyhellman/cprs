Ext.require(['Ext.grid.RowNumberer','Ext.grid.column.Template','Ext.grid.PagingScroller']);

Ext.define('EarmarkApp.view.earmark.List', {
    
  extend: 'Ext.grid.Panel',
  alias: 'widget.earmarklist',
  title: 'View Earmarks',
  store: 'Earmarks',
  
  initComponent: function(){
	 
  	if (Ext.getStore(this.store).count() == 0) {
	 	var sponsorStore = Ext.getStore('Sponsors').load(function() {
	 		Ext.getStore('Earmarks').guaranteeRange(0, 25);
		});
	 }
	   
	 this.verticalScrollerType = 'paginggridscroller';
	 this.invalidateScrollerOnRefresh = false;
	 this.selModel = { selType: 'rowmodel' }
		
	 this.columns = [	
	  {xtype: 'rownumberer', width: 40, sortable: false},					
	  {
	   text: 'Year',
	   sortable: true,
	   dataIndex: 'ENACTED_YEAR',
	   width: 50
	  },
	  {
	   text: 'Sponsor',
	   sortable: true,
	   dataIndex: 'IDSPONSOR',
	   flex: 0.3,
	   renderer: this.renderSponsor
	  },
	  {
	   text: 'Description',
	   sortable: false,
	   dataIndex: 'EARMARK_DESCRIPTION',
	   flex: 0.5
	  },
	  {
	   xtype: 'templatecolumn',
	   align: 'right',
	   text: 'Amt ($000)',
	   width: 75,
	   sortable: true,
	   dataIndex: 'AMT_CONF',
	   tpl: this.expensiveTpl
	  }
	 ];

     this.callParent(arguments);
	   
    }, // initComponent
    
	expensiveTpl : new Ext.XTemplate(
        '<tpl if="AMT_CONF &gt; 999">',
            '<span style="color:red">{AMT_CONF}</span>',
        '</tpl>',
		'<tpl if="AMT_CONF &lt; 1000">',
            '<span style="color:green">{AMT_CONF}</span>',
        '</tpl>'
	),
	
	renderSponsor : function (value, p, record) {
	  
	   var sponsorStore = Ext.getStore('Sponsors');
	   var rec = Ext.getStore('Sponsors').findRecord("IDSPONSOR", value);
	   if (rec) {
	   	return rec.get("FULLNAME");
	   } else {
	   	return ""
	   }
	}
});