Ext.define('CPRS.view.doccat.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.doccatlist',

	title: 'Doc Categories',
	closable: true,
	
	requires: ['CPRS.component.FilterField'],

	initComponent: function() {

		var me = this;
		
		me.store = {
				fields: ['doccategory',
				         'type',
				         'sequence',
				         'mandatory',
				         'link'],
				data  : [
				   {doccategory: 'Pr Report', 
					type: 'Document', 
					sequence: '1',
					mandatory: 'Y',
					link: 'N'},
				   {doccategory: 'Catalog', 
					type: 'Department Pages', 
					sequence: '1',
					mandatory: 'N',
					link: 'Y'},
				   {doccategory: 'Catalog', 
					type: 'Course Pages', 
					sequence: '2',
					mandatory: 'N',
					link: 'Y'},
				   {doccategory: 'Exams', 
					type: 'Final', 
					sequence: '1',
					mandatory: 'N',
					link: 'N'},
				   {doccategory: 'Exams', 
					type: 'Midterm', 
					sequence: '1',
					mandatory: 'N',
					link: 'N'}
					
				   ]
		};

		me.columns = [ {
				text: i18n.doccat_category,
				dataIndex: 'doccategory',
				flex: 1
			}, {
				text: 'Type',
				dataIndex: 'type',
				flex: 1
			}, {
				text: 'Sequence',
				dataIndex: 'sequence',
				flex: 1
			}, {
				text: 'Mandatory',
				dataIndex: 'mandatory',
				flex: 1
			}, {
				text: 'Link',
				dataIndex: 'link',
				flex: 1
			} ];

		me.dockedItems = [ {
			xtype: 'toolbar',
			dock: 'top',
			items: [ {
				text: i18n.doccat_new,
				disabled: false,
				action: 'add',
				iconCls: 'icon-user-add'
			}, {
				text: i18n.doccat_edit,
				disabled: true,
				action: 'edit',
				iconCls: 'icon-user-edit'
			}, {
				text: i18n.doccat_delete,
				disabled: true,
				action: 'delete',
				iconCls: 'icon-user-delete'
			}, '-', {
				text: i18n.excelexport,
				action: 'export',
				iconCls: 'icon-excel',
				href: 'doccatsExport.xls',
				target: '_self'
			}, '->', {
				fieldLabel: i18n.filter,
				labelWidth: 40,
				xtype: 'filterfield'				
			} ]
		}
//		, {
//			xtype: 'pagingtoolbar',
//			dock: 'bottom',
//			store: 'Doccats',
//			displayInfo: true,
//			displayMsg: i18n.doccat_display,
//			emptyMsg: i18n.doccat_no
//		} 
		];

		me.callParent(arguments);

	}

});