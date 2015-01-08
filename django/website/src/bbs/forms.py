#!/usr/bin/env python
# -*- coding: utf-8 -*-

from django import forms


class NewThreadForm(forms.Form):
    title = forms.CharField(max_length=64)
    username = forms.CharField(max_length=16, required=False)
    message = forms.CharField(
                widget=forms.TextInput(attrs={'rows': "10", 'cols': "60"}))


class NewResponseForm(forms.Form):
    username = forms.CharField(max_length=16, required=False)
    message = forms.CharField(
                widget=forms.TextInput(attrs={'rows': "10", 'cols': "60"}))
