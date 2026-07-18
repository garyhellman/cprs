Ext.define('CPRS.view.Viewport', {
	extend: 'Ext.Viewport',
	id: 'viewport',

	layout: {
		type: 'border',
		padding: 5
	},
	defaults: {
		split: true
	},
//     items: [
//      {
//      		xtype: 'panel',
//			html: 'Hello World!',
//			title: "Edit Earmarks"
//      }
//    ]
	
	initComponent: function(){
		var me = this;
		
//		var tabCloseMenu = Ext.create('Ext.ux.TabCloseMenu');
//		tabCloseMenu.closeTabText = 'close';
//		tabCloseMenu.closeOthersTabsText = 'closeothers';
//		tabCloseMenu.closeAllTabsText = 'closeall';
		
/*
		me.items = [{
			region: 'north',
			xtype: 'navigationheader',
			split: false
		}, {
			region: 'center',
			xtype: 'tabpanel',
			plugins: [Ext.create('Ext.ux.TabReorderer'), tabCloseMenu],
			plain: true
		}, {
			region: 'west',
			width: 180,
			xtype: 'sidebar'
		}];
*/
		me.items = [{
			region: 'west',
			width: 180,
			xtype: 'sidebar'
			,
			split: true,
			title: "Menu",
			collapsible: true
		}, {
			region: 'north',
			xtype: 'navigationheader',
			split: false
		},{
			region: 'center',
			plain: true,
			xtype: 'tabpanel'
			//, title: 'Content'
				
			
		}]		
		me.callParent(arguments);
	}
	
	
});
