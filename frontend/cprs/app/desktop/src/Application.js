Ext.define('CPRS.Application', {
	extend: 'Ext.app.Application',
	name: 'CPRS',
	requires: ['CPRS.*'],
	controllers: [
		'AcadInstitutions',
		'Contacts',
		'Homes',
		'Quakes',
		'Reviewers',
		'Schools',
		'Navigation'
	],

	launch: function () {
		Ext.ariaWarn = Ext.emptyFn;
		Ext.getBody().removeCls('launching');
		var splash = document.getElementById('splash');
		if (splash && splash.parentNode) {
			splash.parentNode.removeChild(splash);
		}

		if (Ext.isClassic === true) {
			Ext.create({ xtype: 'mainview', plugins: 'viewport' });
		} else {
			Ext.Viewport.add([{ xtype: 'mainview' }]);
		}
	},

	onAppUpdate: function () {
		Ext.Msg.confirm('Application Update', 'This application has an update, reload?',
			function (choice) {
				if (choice === 'yes') {
					window.location.reload();
				}
			}
		);
	}
});
