#!/usr/bin/env python
# -*- coding: utf-8 -*-

from django.db import models
from django.contrib import admin


class Board(models.Model):
    name = models.CharField(max_length=32, unique=True)
    description = models.TextField(blank=True)

    def __unicode__(self):
        return self.name


class Thread(models.Model):
    title = models.CharField(max_length=64)
    date = models.DateTimeField(auto_now_add=True)
    response_count = models.IntegerField()
    board = models.ForeignKey(Board)

    def __unicode__(self):
        return self.title


class Response(models.Model):
    number = models.IntegerField()
    username = models.CharField(max_length=16, default="Anonymous")
    date = models.DateTimeField(auto_now_add=True)
    pin = models.CharField(max_length=9, default="???")
    message = models.TextField(blank=True)
    thread = models.ForeignKey(Thread)

    def __unicode__(self):
        return self.message


admin.site.register(Board)
admin.site.register(Thread)
admin.site.register(Response)
