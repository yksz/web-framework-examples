from django.conf.urls import patterns, include, url

# Uncomment the next two lines to enable the admin:
# from django.contrib import admin
# admin.autodiscover()

urlpatterns = patterns('bbs.views',
    (r'^$', 'index'),
    (r'^menu/$', 'menu'),
    (r'^main/$', 'main'),
    (r'^(?P<board_id>\d+)/$', 'board'),
    (r'^(?P<board_id>\d+)/add/$', 'add_thread'),
    (r'^(?P<board_id>\d+)/(?P<thread_id>\d+)/$', 'thread'),
    (r'^(?P<board_id>\d+)/(?P<thread_id>\d+)/add/$', 'add_response'),

    # Examples:
    # url(r'^$', 'mysite.views.home', name='home'),
    # url(r'^mysite/', include('mysite.foo.urls')),

    # Uncomment the admin/doc line below to enable admin documentation:
    # url(r'^admin/doc/', include('django.contrib.admindocs.urls')),

    # Uncomment the next line to enable the admin:
    # url(r'^admin/', include(admin.site.urls)),
)
