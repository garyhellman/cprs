Ext.define('CPRS.view.quake.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.quakelist',

    title: 'USGS - M2.5+',
	closable: true,

   store: 'Quakes',
   renderTo: Ext.getBody(),
   width: 700,
   height: 500,
   loadMask: true,
   disableSelection: true,
   invalidateScrollerOnRefresh: false,
   viewConfig: {
     trackOver: false
   },

    initComponent: function() {
        console.log('Initialized Quakes List! ');


       console.log('Initialized Quakes columns. ');
 	   // grid columns
        this.columns = [
 	   {
 	      xtype: 'rownumberer',
 	      width: 50,
 	      sortable: false
 	   },{
 	      id: 'title',
 	      text: "Title",
 	      dataIndex: 'title',
 	      flex: 1,
 	      //renderer: this.renderTitle,
 	      renderer: function(value, p, record){
  	    	 //console.log('In renderTitle ' + value + record.data.link);
 	    	return Ext.String.format('<a href="{1}" target="_blank">{0}</a>',
 	    			value, record.data.link );

 	      },
 	      sortable: false
 	   },{
 	      id: 'pubDate',
 	      text: "Published Date",
 	      dataIndex: 'pubDate',
 	      width: 130,
 	      renderer: Ext.util.Format.dateRenderer('n/j/Y g:i A'),
 	      sortable: true
 	   }];
        
//      function renderTitle (value, p, record) {
//    	console.log('In renderTitle ' + value + " : " + record.data.link);
//    	return Ext.String.format('<a href="{1}" target="_blank">{0}</a>',
//    			value,
//    			record.data.link
//    	);
//    	//      return "test01";
//      }
//	   //renderTo: Ext.getBody();
  	
      console.log('Quakes List: before callParent. ');
      this.callParent(arguments);
	
  
}});



