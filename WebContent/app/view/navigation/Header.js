Ext.define('CPRS.view.navigation.Header', {
	alias: 'widget.navigationheader',
	extend: 'Ext.container.Container',
	height: 35,
	layout: {
		type: 'hbox',
		align: 'stretch'
	},

	initComponent: function() {
		var me = this;
		me.items = [ {
		html: 'CPRS',
		cls: 'appHeader'
	}, {
		xtype: 'tbspacer',
		flex: 1
	}, {
		xtype: 'label',
		text: 'i18n.login_loggedon : ',
		width: 200,
		margins: {
			top: 6,
			right: 0,
			bottom: 0,
			left: 0
		}
	}, {
		xtype: 'tbspacer',
		width: 10
	}, {
		xtype: 'button',
		text: 'i18n.logout',
		iconCls: 'icon-logout',
		href: 'j_spring_security_logout',
		target: '_self',
		margins: {
			top: 2,
			right: 0,
			bottom: 10,
			left: 0
		}
		}, {
			xtype: 'tbspacer',
			width: 10
		}, {
			xtype: 'button',
			text: 'i18n.logout',
			iconCls: 'icon-logout',
			href: 'j_spring_security_logout',
			target: '_self',
			margins: {
				top: 2,
				right: 0,
				bottom: 10,
				left: 0
			}
		} ];

		me.callParent(arguments);

	}

});