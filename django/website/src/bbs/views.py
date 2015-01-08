#!/usr/bin/env python
# -*- coding: utf-8 -*-

from django.http import HttpResponseRedirect
from django.shortcuts import render_to_response
from django.shortcuts import get_object_or_404
from django.template import RequestContext

from bbs.models import Board
from bbs.models import Thread
from bbs.models import Response
from bbs.forms import NewThreadForm
from bbs.forms import NewResponseForm


def index(request):
    return render_to_response('bbs/index.html')


def menu(request):
    board_list = Board.objects.all()
    return render_to_response('bbs/menu.html',
                              {'board_list': board_list},
                              context_instance=RequestContext(request))


def main(request):
    return render_to_response('bbs/main.html',
                              {},
                              context_instance=RequestContext(request))


def board(request, board_id):
    board = get_object_or_404(Board, pk=board_id)
    thread_list = board.thread_set.all()
    return render_to_response('bbs/board.html',
                              {'board': board,
                               'thread_list': thread_list},
                              context_instance=RequestContext(request))


def add_thread(request, board_id):
    if request.method == 'POST':
        form = NewThreadForm(request.POST)
        if form.is_valid():
            thread = Thread()
            thread.title = form.cleaned_data['title']
            thread.response_count = 1
            thread.board = Board.objects.get(id=board_id)
            thread.save()

            response = Response()
            response.number = 1
            username = form.cleaned_data['username']
            if username:
                response.username = username
            response.message = form.cleaned_data['message']
            response.thread = thread
            response.save()

    return HttpResponseRedirect('/bbs/' + board_id + '/')


def thread(request, board_id, thread_id):
    board = get_object_or_404(Board, pk=board_id)
    thread = get_object_or_404(Thread, pk=thread_id)
    response_list = thread.response_set.all()
    return render_to_response('bbs/thread.html',
                              {'board': board,
                               'thread': thread,
                               'response_list': response_list},
                              context_instance=RequestContext(request))


def add_response(request, board_id, thread_id):
    if request.method == 'POST':
        form = NewResponseForm(request.POST)
        if form.is_valid():
            thread = get_object_or_404(Thread, pk=thread_id)
            thread.response_count += 1
            thread.save()

            response = Response()
            response.number = thread.response_count
            username = form.cleaned_data['username']
            if username:
                response.username = username
            response.message = form.cleaned_data['message']
            response.thread = thread
            response.save()

    return HttpResponseRedirect('/bbs/' + board_id + '/' + thread_id + '/')
