Ext.define('CPRS.view.navigation.SideBar', {
	alias: 'widget.sidebar',
	extend: 'Ext.panel.Panel',
	stateId: 'sidebar',
	store: 'Navigation',

	title: 'i18n.navigation',
	collapsible: true,
	layout: 'fit',
	minWidth: 100,
	maxWidth: 200,		
	root: {
		text: 'root node'
	},		
    rootVisible: false,
	initComponent: function() {
//        this.store = Ext.create('CPRS.store.Navigation', {
//            listeners: {
//                load: {
//                    //fn: this.onFoldersLoad,
//                    scope: this
//                }
//            },
//            root: {
//                text: 'My Root',
//                expanded: true
//            }
//        });
		
		var me = this;
		me.items = [ {
			xtype: 'treepanel',
			border: 0,
	        store: 'Navigation', 
/*	        	
	        	[
{
	"text":"root",
	"children":[{
	    "text":"navigation_administration",
	    "iconCls": "icon-administration",
	    "expanded": "true", 
	    "children":[
	    	{
	    	"text": "Reviewers",
   		    "iconCls": "icon-administration",
		    "expanded": "true", 
		    "children":[
		    	{
	 	    	"text": "Manage Reviewers", 
		    	"iconCls": "icon-users",
		    	"view": "reviewerlist", 
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	},{
	 	    	"text": "persons", 
		    	"iconCls": "icon-users",
		    	"view": "personlist", 
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	},{
		    	"text": "menu_000016", 
		    	"iconCls": "icon-users",
		    	"view": "homelist", 	    	
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	}
		    	]
		    },
	    	{
	    	"text": "Manage",
   		    "iconCls": "icon-administration",
		    "expanded": "true", 
		    "children":[
		    	{
		    	"text": "doccat_doccat", 
		    	"iconCls": "icon-users",
		    	"view": "doccatlist", 	    	
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	},{
		    	"text": "menu_00004", 
		    	"iconCls": "icon-users",
		    	"view": "homelist", 	    	
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	},{
		    	"text": "menu_00005", 
		    	"iconCls": "icon-users",
		    	"view": "homelist", 	    	
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	},{
		    	"text": "menu_00006", 
		    	"iconCls": "icon-users",
		    	"view": "homelist", 	    	
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	},{
		    	"text": "user_users", 
		    	"iconCls": "icon-users",
		    	"view": "userlist", 	    	
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	},{
		    	"text": "menu_000011", 
		    	"iconCls": "icon-users",
		    	"view": "homelist", 	    	
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	},{
		    	"text": "menu_000012", 
		    	"iconCls": "icon-users",
		    	"view": "homelist", 	    	
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	},{
		    	"text": "menu_000013", 
		    	"iconCls": "icon-users",
		    	"view": "homelist", 	    	
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	}
		    	]
		    },
	    	{
	    	"text": "Users",
   		    "iconCls": "icon-administration",
		    "expanded": "true", 
		    "children":[
		    	{
	 	    	"text": "menu_000015", 
		    	"iconCls": "icon-users",
		    	"view": "reviewerlist", 	    	
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	},{
		    	"text": "menu_000016", 
		    	"iconCls": "icon-users",
		    	"view": "homelist", 	    	
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	}
		    	]
		    },
	    	{
	    	"text": "Setup",
   		    "iconCls": "icon-administration",
		    "expanded": "true", 
		    "children":[
			    {
		    	"text": "menu_00007", 
		    	"iconCls": "icon-users",
		    	"view": "statelist", 	    	
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	},{
		    	"text": "menu_00008", 
		    	"iconCls": "icon-users",
		    	"view": "homelist", 	    	
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	},{
		    	"text": "menu_00009", 
		    	"iconCls": "icon-users",
		    	"view": "homelist", 	    	
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	},{
		    	"text": "home_home", 
		    	"iconCls": "icon-users",
		    	"view": "homelist", 	    	
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	},{
		    	"text": "earth_quakes", 
		    	"iconCls": "icon-users",
		    	"view": "quakelist", 	    	
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	},{
		    	"text": "menu_000014", 
		    	"iconCls": "icon-users",
		    	"view": "homelist", 	    	
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	},{
		    	"text": "school_school", 
		    	"iconCls": "icon-users",
		    	"view": "schoollist", 	    	
		    	leaf:true,
		    	"roles": ["ROLE_ADMIN"]
		    	}
			    ]
			}]
		}]
}],
*/
	        rootVisible: false,
	        animate: false
		} ];

		//me.store = Ext.data.StoreManager.lookup(this.store);

		me.callParent(arguments);

	}
});