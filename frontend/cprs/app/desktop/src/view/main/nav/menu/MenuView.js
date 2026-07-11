Ext.define('CPRS.view.nav.menu.MenuView', {
	extend: 'Ext.list.Tree',
	requires: [
		'Ext.data.TreeStore',
	],
	xtype: 'menuview',
	ui: 'nav',
	scrollable: true,
	bind: { 
		store: '{menu}',
		micro: '{navCollapsed}' 
	},
	expanderFirst: false,
	expanderOnly: false,
	listeners: {
		selectionchange: 'onMenuViewSelectionChange'
	},
});
