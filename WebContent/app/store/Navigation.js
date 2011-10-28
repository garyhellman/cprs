Ext.define('CPRS.store.Navigation', {
	extend: 'Ext.data.TreeStore',
	autoLoad: true,	
    nodeParam: 'id',
//    proxy: {
//        type: 'direct',
//        directFn: navigationService.getNavigation
//    }	
//        model: 'Task',
      proxy: {
          type: 'ajax',
          //the store will get the content from the .json file
          url: 'data/menu.json'
      },
/*      
    data: [
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
}
           
           ],
*/    
        folderSort: true


});
