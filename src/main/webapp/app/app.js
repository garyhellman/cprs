/**
 * Ext JS Library 4.0.0
 * Copyright(c) 2006-2011 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 *	
 */
Ext.require([
             'Ext.form.*',
             'Ext.tip.QuickTipManager',
             'Ext.layout.container.Accordion'
//			 ,
//             'CPRS.component.Notification'
         ]);

Ext.application({
    name: 'CPRS',
	appFolder: 'app',
	controllers: [ 
	              'AcadInstitutions',
	              'Contacts',
	              'Homes', 
//        'Persons', 
////        'States', 
//        'Users', 
////        'Doctypes', 
//        'Doccats', 
////        'TemplateCats', 
////        'Templates', 
////        'Decisions', 
////        'ReasonTypes', 
////        'Roles', 
////        'TaskACLs', 
////        'Meetings', 
//        'Notifications', 
        'Quakes', 
        'Reviewers', 
////        'NotifyReviewers', 
        'Schools', 
        'Navigation'
//		   , 
//        'PollChart' 
        
    ],

//    launch: function() {
//        Ext.create('Ext.container.Viewport', {
//            layout: 'fit',
//            items: [
//                {
//                    xtype: 'contactlist'
//                }
//            ]
//        });
//    }

autoCreateViewport: true,
launch: function() {

	if (this.hasLocalstorage()) {
		Ext.state.Manager.setProvider(Ext.create('Ext.state.LocalStorageProvider'));
	} else {
		Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));
	}

/*
	Ext.direct.Manager.on('event', function(e) {
		if (e.code && e.code === 'parse') {
			window.location.reload();
		}
	});
	
	Ext.direct.Manager.on('exception', function(e) {	
		if (e.message === 'accessdenied') {
			CPRS.component.Notification.error(i18n.error, i18n.error_accessdenied);
		} else {
			CPRS.component.Notification.error(i18n.error, e.message);
		}
	});		
*/		
/*
	Ext.apply(Ext.form.field.VTypes, {
		password: function(val, field) {
			if (field.initialPassField) {
				var pwd = field.up('form').down('#' + field.initialPassField);
				return (val == pwd.getValue());
			}
			return true;
		},

		passwordText: i18n.user_passworddonotmatch
	});
*/
},
hasLocalstorage: function() {
	try {
		return !!localStorage.getItem;
	} catch (e) {
		return false;
	}
}

});
