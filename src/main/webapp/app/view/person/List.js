Ext.define('CPRS.view.person.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.personlist',
//	stateId: 'personList',
	store: 'Persons',

	title: "Persons",
	closable: true,
	
//	requires: ['CPRS.component.FilterField'],

	initComponent: function() {
        console.log('Initialized Persons List!');
    	var rowEditing = Ext.create('Ext.grid.plugin.RowEditing');

		var me = this;

		me.plugins = [rowEditing];
		
		me.columns = [ {
            text: 'ID',
            width: 40,
            sortable: true,
            dataIndex: 'id'
        }, {
            text: 'Email',
            flex: 1,
            sortable: true,
            dataIndex: 'email',
            field: {
                xtype: 'textfield'
            }
        }, {
            header: 'First',
            width: 80,
            sortable: true,
            dataIndex: 'first',
            field: {
                xtype: 'textfield'
            }
        }, {
            text: 'Last',
            width: 80,
            sortable: true,
            dataIndex: 'last',
            field: {
                xtype: 'textfield'
            }
		} ];

		me.dockedItems = [ {
			xtype: 'toolbar',
			dock: 'top',
			items: [ {
				text: "New",
				disabled: false,
				action: 'add',
				iconCls: 'icon-user-add'
			}, {
				text: "Edit",
				disabled: true,
				action: 'edit',
				iconCls: 'icon-user-edit'
			}, {
				text: "Delete",
				disabled: true,
				action: 'delete',
				iconCls: 'icon-user-delete'
			}, '-', {
				text: "Excel Report",
				action: 'export',
				iconCls: 'icon-excel',
				href: 'usersExport.xls',
				target: '_self'
			}, '->', {
				fieldLabel: "Filter",
				labelWidth: 40,
				xtype: 'filterfield'				
			} ]
		}, {
			xtype: 'pagingtoolbar',
			dock: 'bottom',
			store: 'Users',
			displayInfo: true,
			displayMsg: "UserDisplay",
			emptyMsg: "no User"
		} ];

		me.callParent(arguments);

	}

});